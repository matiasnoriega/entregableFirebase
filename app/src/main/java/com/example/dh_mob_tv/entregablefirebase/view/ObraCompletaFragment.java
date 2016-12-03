package com.example.dh_mob_tv.entregablefirebase.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dh_mob_tv.entregablefirebase.R;
import com.example.dh_mob_tv.entregablefirebase.controller.ArtistController;
import com.example.dh_mob_tv.entregablefirebase.model.Paint;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

/**
 * Created by dh-mob-tv on 21/11/16.
 */
public class ObraCompletaFragment extends Fragment {

    private Paint paint;

    public ObraCompletaFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewADevolver = inflater.inflate(R.layout.layout_obra_completa, container, false);

        Bundle bundle = getArguments();
        paint = (Paint) bundle.getSerializable("pintura");
        setHasOptionsMenu(true);

        String titulo = paint.getName() + " de " + bundle.getString("autor");
        android.widget.Toolbar myToolbar = (android.widget.Toolbar) viewADevolver.findViewById(R.id.my_toolbar);
        myToolbar.setTitle(titulo);
        myToolbar.inflateMenu(R.menu.menutoolbar);
        getActivity().setActionBar(myToolbar);


        ImageView imageViewObraCompleta = (ImageView) viewADevolver.findViewById(R.id.image_fragment_pantallaCompleta);


        ArtistController artistController = new ArtistController();
        artistController.setImageFirebaseController(paint.getImage(), imageViewObraCompleta, getContext());


        return viewADevolver;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menutoolbar, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fotoButton:
                return true;
            case R.id.tweetButton:
                tweet(getView());
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void tweet(final View view){

        TwitterSession session = Twitter.getSessionManager().getActiveSession();

        if(session!=null){
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();

            storageRef.child(paint.getImage()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    String msg = "Estoy en el MoMMA mirando " + paint.getName() + "\n #arte #momma" + "\n"+ uri.toString();

                    TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                            .text(msg);
                    builder.show();
                }
            });
        }else{
            Toast.makeText(view.getContext(), "Tenes que estar logueado en Twitter", Toast.LENGTH_SHORT).show();
        }



    }

}
