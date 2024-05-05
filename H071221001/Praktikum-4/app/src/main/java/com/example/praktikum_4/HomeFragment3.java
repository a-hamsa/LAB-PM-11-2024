package com.example.praktikum_4;


public final class HomeFragment3 implements PostAdapter.ClickListener {
    public final HomeFragment homeFragment;

    public HomeFragment3 (HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    public final void onDeleteButtonClicked(Model model) {
        this.homeFragment.HomeFragment3 (model);
    }
}
