package h.example.adityaaggarwal.h;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.honorato.multistatetogglebutton.MultiStateToggleButton;

public class RegisterActivity extends AppCompatActivity {



    private static int RESULT_LOAD_IMAGE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView buttonLoadImage = (ImageView) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

               startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        EditText editFName = (EditText) findViewById(R.id.editFirstName);
        EditText editLName = (EditText) findViewById(R.id.editLastName);
        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        EditText editPassword = (EditText) findViewById(R.id.editPassword);

//      TextView TermsCondition = (TextView) findViewById(R.id.terms_and_conditions);
        ImageView editImage = (ImageView) findViewById(R.id.imgView);
        MultiStateToggleButton toggleButton = (MultiStateToggleButton)findViewById(R.id.mstb_multi_id);
        toggleButton.setValue(0);
        Button registerButton = (Button) findViewById(R.id.sign_up_button);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

//            Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(i, RESULT_LOAD_IMAGE);

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.imgView);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//            imageView.setImageBitmap(getScaledBitmap(picturePath, 800, 800));



        }

    }


}
