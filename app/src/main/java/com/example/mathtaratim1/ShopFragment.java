package com.example.mathtaratim1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ShopFragment extends Fragment {

    private OnGemPurchaseListener gemPurchaseListener; // Interface untuk komunikasi dengan MainActivity

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGemPurchaseListener) {
            gemPurchaseListener = (OnGemPurchaseListener) context;
        } else {
            throw new RuntimeException(context.toString() + " harus mengimplementasikan OnGemPurchaseListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        View btnGem15K = view.findViewById(R.id.forgem15k);
        View btnGem85K = view.findViewById(R.id.textView34);
        View btnGem175K = view.findViewById(R.id.textView35);

        btnGem15K.setOnClickListener(v -> buyGems(75));
        btnGem85K.setOnClickListener(v -> buyGems(250));
        btnGem175K.setOnClickListener(v -> buyGems(500));

        return view;
    }

    private void buyGems(int amount) {
        if (gemPurchaseListener != null) {
            gemPurchaseListener.onGemPurchased(amount); // Kirim jumlah gems ke MainActivity
            Toast.makeText(getActivity(), "Gems bertambah: " + amount, Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnGemPurchaseListener {
        void onGemPurchased(int gems);
    }
}
