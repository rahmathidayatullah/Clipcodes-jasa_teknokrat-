package youtube.clipcodes.firebase_servicepc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import youtube.clipcodes.R;
import youtube.clipcodes.firebase_servicepc.Bloggg;
import youtube.clipcodes.firebase_servicepc.posttt;
import youtube.clipcodes.firebase_servicepc.servicepclist;

public class servicepclist extends AppCompatActivity {

    private RecyclerView mBlogList;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_servicepc);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Blog_servicepc");

        mBlogList = (RecyclerView) findViewById(R.id.blog_list_servicepc);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
    }

    //blogrow


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Bloggg, servicepclist.BlogggViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Bloggg, servicepclist.BlogggViewHolder>(

                Bloggg.class, R.layout.activity_servicepclist,servicepclist.BlogggViewHolder.class, mDatabase

        ) {
            @Override
            protected void populateViewHolder(servicepclist.BlogggViewHolder viewHolder, Bloggg model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setGit(model.getGit());
                viewHolder.setHp(model.getHp());
                viewHolder.setImage(getApplicationContext(),model.getImage());

            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class BlogggViewHolder extends RecyclerView.ViewHolder {

        View mview;

        public BlogggViewHolder(View itemView) {
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

        public void setImage(Context ctx, String image){

            ImageView post_image = (ImageView) mview.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);

        }

    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, servicepclist.class);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override //klik item
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add){
            startActivity(new Intent(servicepclist.this, posttt.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
