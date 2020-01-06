package youtube.clipcodes.firebase_desain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import youtube.clipcodes.R;

public class desainlist extends AppCompatActivity {

    private RecyclerView mBlogList;

    public Button mremove;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Blog");

        mBlogList = (RecyclerView) findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
    }

    //blogrow


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Blog, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(

                Blog.class, R.layout.activity_desainlist,BlogViewHolder.class, mDatabase

        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setGit(model.getGit());
                viewHolder.setHp(model.getHp());
                viewHolder.setImage(getApplicationContext(),model.getImage());



            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {

        View mview;

        public BlogViewHolder(View itemView) {
            super(itemView);

            mview = itemView;

        }

        public void setTitle(String title){

            TextView post_title = (TextView) mview.findViewById(R.id.post_title);
            post_title.setText(title);

        }

        public void setDesc(String desc){

            TextView post_desc = (TextView) mview.findViewById(R.id.post_desc);
            post_desc.setText(desc);
        }

        public void setGit(String git){

            TextView post_git = (TextView) mview.findViewById(R.id.post_git);
            post_git.setText(git);

        }

        public void setHp (String hp){

            TextView post_hp = (TextView) mview.findViewById(R.id.post_hp);
            post_hp.setText(hp);

        }

        public void setImage(Context ctx,String image){

            ImageView post_image = (ImageView) mview.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);

        }

    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, desainlist.class);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override //klik item
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add){
            startActivity(new Intent(desainlist.this, post.class));

        }
        return super.onOptionsItemSelected(item);
    }


}
