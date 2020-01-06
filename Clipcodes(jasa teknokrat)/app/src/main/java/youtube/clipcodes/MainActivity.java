package youtube.clipcodes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


import youtube.clipcodes.TabLayout.Page_1;
import youtube.clipcodes.TabLayout.Page_2;
import youtube.clipcodes.TabLayout.Page_3;
import youtube.clipcodes.login.Login;

public class MainActivity extends AppCompatActivity{

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;

    TabLayout MyTabs;
    ViewPager MyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Login.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

       /* textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);*/

        /*textViewUserEmail.setText("Welcome"+user.getEmail());*/

        /*buttonLogout = (Button) findViewById(R.id.buttonLogout);*/




        MyTabs = (TabLayout)findViewById(R.id.MyTabs);
        MyPage = (ViewPager)findViewById(R.id.MyPage);

        MyTabs.setupWithViewPager(MyPage);
        SetUpViewPager(MyPage);

        //Thanks For Watching and Keep Learning With ClipCodes on YouTube
    }

    public void SetUpViewPager (ViewPager viewpage){
        MyViewPageAdapter Adapter = new MyViewPageAdapter(getSupportFragmentManager());

        Adapter.AddFragmentPage(new Page_1(), "Desainer");
        Adapter.AddFragmentPage(new Page_2(), "Programers");
        Adapter.AddFragmentPage(new Page_3(), "Service PC");
        //We Need Fragment class now

        viewpage.setAdapter(Adapter);

    }

    /*@Override
    public void onClick(View v) {
        if (v == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Login.class) );
        }

    }*/

    @Override //klik item
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.chatglobal){
            startActivity(new Intent(MainActivity.this, MainActivityChat.class));
        }

        return super.onOptionsItemSelected(item);
    }






    public class MyViewPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> MyFragment = new ArrayList<>();
        private List<String> MyPageTittle = new ArrayList<>();

        public MyViewPageAdapter(FragmentManager manager){
            super(manager);
        }

        public void AddFragmentPage(Fragment Frag, String Title){
            MyFragment.add(Frag);
            MyPageTittle.add(Title);
        }

        @Override
        public Fragment getItem(int position) {
            return MyFragment.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return MyPageTittle.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}