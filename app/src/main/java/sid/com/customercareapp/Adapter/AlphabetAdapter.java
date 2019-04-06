package sid.com.customercareapp.Adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.List;

import sid.com.customercareapp.Common.Common;
import sid.com.customercareapp.Interface.IOnAlphabetClickListener;
import sid.com.customercareapp.R;


public class AlphabetAdapter extends RecyclerView.Adapter<AlphabetAdapter.MyViewHolder> {

    List<String> alphabetList;
    IOnAlphabetClickListener iOnAlphabetClickListener;

    public void setiOnAlphabetClickListener(IOnAlphabetClickListener iOnAlphabetClickListener) {
        this.iOnAlphabetClickListener = iOnAlphabetClickListener;
    }

    public AlphabetAdapter() {
        alphabetList = Common.genAlphabet();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.alphabet_item,viewGroup,false)
                ;
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        TextDrawable drawable;
        //Get available postion of character
        final int available_postion = Common.alphabet_available.indexOf(alphabetList.get(i));
        if(available_postion != -1) // If character is available in list
        {
            drawable =  TextDrawable.builder().buildRound(alphabetList.get(i),Color.GREEN);
        }
        else {
            //if character not available set Gray
            drawable =  TextDrawable.builder().buildRound(alphabetList.get(i),Color.GRAY);
        }
        myViewHolder.alphabet_avatar.setImageDrawable(drawable);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When user choose alphabet character ,just go back MainActivity and Scroll to postion of first character
                iOnAlphabetClickListener.onAlphabetClickListener(alphabetList.get(i),i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alphabetList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView alphabet_avatar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            alphabet_avatar = (ImageView)itemView.findViewById(R.id.alpahabet_avatar);
        }
    }
}
