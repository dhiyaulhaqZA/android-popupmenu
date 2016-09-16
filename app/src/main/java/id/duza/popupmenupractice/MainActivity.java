package id.duza.popupmenupractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnShow;
    private Button btnBottomShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btn_popup);
        btnShow.setOnClickListener(new View.OnClickListener() { //Show popup menu when button clicked
            @Override
            public void onClick(View view) {
                //Constructor to create a new popup menu with an anchor view and alignment gravity.
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnShow, Gravity.END);
                //used to inflate menu items from XML into the menu returned by getMenu()
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                //Handle menu item click
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "Button top : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true; // return true if event was handled, false otherwise
                    }
                });
                popupMenu.show(); //Show the menu popup anchored to the view specified during construction.
            }
        });

        btnBottomShow = (Button) findViewById(R.id.btn_popup_bottom);
        btnBottomShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnBottomShow); // (context, view anchor)
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                //Sets the gravity used to align the popup window to its anchor view, via setGravity method
                popupMenu.setGravity(Gravity.END);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "Button bottom : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true; // return true if event was handled, false otherwise
                    }
                });
                popupMenu.show();
            }
        });
    }
}
