package io.intrepid.animationexercise.screens.detail;

import io.intrepid.animationexercise.base.BaseContract;

class DetailContract {
    public interface View extends BaseContract.View {
        void animateImage();

        void showCat();

        void animatePowerUp();

        void displayInstructions();
    }

    public interface Presenter extends BaseContract.Presenter<View> {
        void onBackPressed();

        void onViewCatClicked();

        void onCatImageClicked();
    }
}
