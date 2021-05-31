package sg.edu.rp.c346.id19048236.mylocalbanks;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textDBS,textOCBC,textUOB;
    String textClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDBS=findViewById(R.id.textViewDBS);
        textOCBC=findViewById(R.id.textViewOCBC);
        textUOB=findViewById(R.id.textViewUOB);

        registerForContextMenu(textDBS);
        registerForContextMenu(textOCBC);
        registerForContextMenu(textUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.EnglishSelection){
            textDBS.setText(getString(R.string.dbs));
            textOCBC.setText(getString(R.string.ocbc));
            textUOB.setText(getString(R.string.uob));
        }
        else if(id== R.id.ChineseSelection){
            textDBS.setText(getString(R.string.chineseDBS));
            textOCBC.setText(getString(R.string.chineseOCBC));
            textUOB.setText(getString(R.string.chineseUOB));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.sec_menu,menu);
        if (v == textDBS) {
            textClick="DBS";
        }
        else if(v==textOCBC){
            textClick="OCBC";

        }
        else if(v==textUOB){
            textClick="UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(textClick.equalsIgnoreCase("DBS")){
                        if(id==R.id.WebsiteSelection){
                            Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlDBS)));
                            startActivity(intentWeb);

                        }
                        else if(id==R.id.ContactSelection){
                            Intent intentContact= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+getString(R.string.numDBS)));
                            startActivity(intentContact);

                        }
                        else if(id==R.id.ToggleSelection){
                            if (textDBS.getCurrentTextColor()== Color.BLACK){
                                textDBS.setTextColor(Color.RED);
                            }
                            else if(textDBS.getCurrentTextColor()==Color.RED){
                                textDBS.setTextColor(Color.BLACK);
                }
            }
        }
        else if(textClick.equalsIgnoreCase("OCBC")){
            if(id==R.id.WebsiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlOCBC)));
                startActivity(intentWeb);

            }
            else if(id==R.id.ContactSelection){
                Intent intentContact= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+getString(R.string.numOCBC)));
                startActivity(intentContact);

            }
            else if(id==R.id.ToggleSelection){
                if (textOCBC.getCurrentTextColor()== Color.BLACK){
                    textOCBC.setTextColor(Color.RED);
                }
                else if(textOCBC.getCurrentTextColor()==Color.RED){
                    textOCBC.setTextColor(Color.BLACK);
                }
            }
        }
        else if(textClick.equalsIgnoreCase("UOB")){
            if(id==R.id.WebsiteSelection){
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlUOB)));
                startActivity(intentWeb);

            }
            else if(id==R.id.ContactSelection){
                Intent intentContact= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+getString(R.string.numUOB)));
                startActivity(intentContact);

            }
            else if(id==R.id.ToggleSelection){
                if (textUOB.getCurrentTextColor()== Color.BLACK){
                    textUOB.setTextColor(Color.RED);
                }
                else if(textUOB.getCurrentTextColor()==Color.RED){
                    textUOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}