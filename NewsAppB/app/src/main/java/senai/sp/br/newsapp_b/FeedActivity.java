package senai.sp.br.newsapp_b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity implements Callback{

    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private List<Article> artigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        recyclerView = findViewById(R.id.artigos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recycleAdapter = new RecycleAdapter(artigos);
        recyclerView.setAdapter(recycleAdapter);

        PkRSS.with(this)
                .load("https://www.androidpro.com.br/feed")
                .skipCache()
                .callback(this)
                .async();

    }

    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        artigos.clear();
        artigos.addAll(newArticles);
        recycleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed() {

    }
}