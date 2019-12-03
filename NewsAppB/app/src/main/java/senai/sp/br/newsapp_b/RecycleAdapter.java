package senai.sp.br.newsapp_b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecycleAdapter
        extends RecyclerView.Adapter<ViewHolderFeed>{

    private List<Article> artigos;

    public RecycleAdapter(List<Article> artigos){
        this.artigos = artigos;
    }

    @NonNull
    @Override
    public ViewHolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolderFeed(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFeed holder, int position) {

        Article artigo = artigos.get(position);
        holder.tituloArtigo.setText(artigo.getTitle());
        holder.descricaoArtigo.setText(artigo.getAuthor());

    }

    @Override
    public int getItemCount() {
        return artigos.size();
    }
}
