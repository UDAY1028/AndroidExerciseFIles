package com.example.fireuploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class MainActivity extends AppCompatActivity {

    StorageReference mStorageReference;

    ImageView mImageView;
    Button mButton;
    ProgressBar mProgressBar;
//    ProgressBar progressBar;
//    int progress = 0;


    private static final int GALLERY = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progressBar);
        mImageView = findViewById(R.id.imageView);
        mButton = findViewById(R.id.button);

       mProgressBar.setVisibility(View.GONE);


        mStorageReference = FirebaseStorage.getInstance().getReference();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                startActivityForResult(intent, GALLERY);
            }
        });

        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY) {
            Uri uri = data.getData();
            mImageView.setImageURI(uri);
            mProgressBar.setVisibility(View.VISIBLE);


            StorageReference fileName = mStorageReference.child("photos/" + uri.getLastPathSegment() + ".png");
            fileName.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(MainActivity.this, "successfully uploaded.", Toast.LENGTH_SHORT).show();
                    mProgressBar.setVisibility(View.GONE);
//                    progressBar.setVisibility(View.GONE);
//                    mImageView.setVisibility(View.GONE);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Failed to upload.", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

//    public void mProgress (final int progress) {
//
//        progressBar.setProgress(progress);
//
//        final Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });
//
//
//    }
}

