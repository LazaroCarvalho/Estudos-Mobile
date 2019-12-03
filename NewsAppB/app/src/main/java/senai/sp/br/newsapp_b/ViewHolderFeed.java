package senai.sp.br.newsapp_b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderFeed extends RecyclerView.ViewHolder {

    public ImageView imagemArtigo;
    public TextView tituloArtigo;
    public TextView descricaoArtigo;
    public Button btnLerArtigo;

    public ViewHolderFeed(View cardNoticia) {
        super(cardNoticia);
        imagemArtigo = cardNoticia.findViewById(R.id.imagem_artigo);
        tituloArtigo = cardNoticia.findViewById(R.id.titulo_artigo);
        descricaoArtigo = cardNoticia.findViewById(R.id.descricao_artigo);
        btnLerArtigo = cardNoticia.findViewById(R.id.btn_ler_artigo);
    }



}
