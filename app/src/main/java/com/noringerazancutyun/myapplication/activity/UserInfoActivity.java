package com.noringerazancutyun.myapplication.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.noringerazancutyun.myapplication.R;
import com.noringerazancutyun.myapplication.models.UserInform;

import java.util.List;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int CAMERA_REQUEST_CODE  = 2;
    private static final int CAMERA_PERMISSION_CODE = 10;

    private EditText mName, mSurname, mPhone;
    private ImageView mSaveButton, mUserImage;
    ProgressDialog mDialog;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDataBaseReference;
    private StorageReference mReference;
    private String mImagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        mName = findViewById(R.id.user_name);
        mSurname = findViewById(R.id.user_surname);
        mPhone = findViewById(R.id.user_phone);
        mUserImage = findViewById(R.id.user_image);
        mSaveButton = findViewById(R.id.create_img_register_activity);

        mProgressDialog = new ProgressDialog(UserInfoActivity.this);

        registerForContextMenu(mUserImage);

        mAuth = FirebaseAuth.getInstance();
        mDataBaseReference = FirebaseDatabase.getInstance().getReference("User");
        mReference = FirebaseStorage.getInstance().getReference();

        mSaveButton.setOnClickListener(this);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.gallery_or_camera_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.from_gallery:
                openGallery();
                break;
            case R.id.from_camera:
                getCameraPermission();
                break;
            case R.id.cancel:
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void writeToDataBase(){

        String name = mName.getText().toString().trim();
        String surname = mSurname.getText().toString();
        String phone = mPhone.getText().toString();
        String email = user.getEmail();

        UserInform userInfo = new UserInform(name, email, surname, phone);
        mDataBaseReference.child(user.getUid()).setValue(userInfo);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case (R.id.create_img_register_activity):
                writeToDataBase();
                Toast.makeText(UserInfoActivity.this, "User createrd", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(UserInfoActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
        }

    }

    public  void openGallery(){
        Intent galleryAction = new Intent();
        galleryAction.setType("image/*");
        galleryAction.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryAction,"Select Picture"), GALLERY_REQUEST_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == CAMERA_PERMISSION_CODE) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                cameraPermissionResult(true);
            } else {
                cameraPermissionResult(false);
            }
        }


    }
    private void getCameraPermission() {
        if(ContextCompat.checkSelfPermission(UserInfoActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(UserInfoActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_CODE);

        } else {
            cameraPermissionResult(true);
        }
    }

    private void cameraPermissionResult(boolean cameraPermissionGranted) {
        if(cameraPermissionGranted) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        } else {
            Toast.makeText(UserInfoActivity.this, "CANCEL",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {

            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
            Uri imageUri = data.getData();
            Uri realPath = getRealPathFromURI(imageUri);

            StorageReference myPath = mReference.child("USER BOX").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
            myPath.putFile(realPath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

//                   mProgressDialog.dismiss();
                }
            });
        }

    }
    public Uri getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return Uri.parse(cursor.getString(idx));
    }
}
