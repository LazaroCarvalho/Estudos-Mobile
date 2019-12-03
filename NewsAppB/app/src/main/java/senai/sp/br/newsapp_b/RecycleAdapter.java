package senai.sp.br.newsapp_b;

import android.content.Intent;
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
    public void onBindViewHolder(@NonNull final ViewHolderFeed holder, int position) {

        final Article artigo = artigos.get(position);
        holder.tituloArtigo.setText(artigo.getTitle());
        holder.descricaoArtigo.setText(artigo.getAuthor());
        new DownloadImageTask(holder.imagemArtigo).execute(artigo.getEnclosure().getUrl());

        holder.btnLerArtigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirNavegador = new Intent(Intent.ACTION_VIEW, artigo.getSource());
                holder.itemView.getContext().startActivity(abrirNavegador);
            }
        });

    }

    @Override
    public int getItemCount() {
        return artigos.size();
    }
}
