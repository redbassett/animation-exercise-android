package io.intrepid.animationexercise.screens.detail;

import android.support.annotation.NonNull;

import io.intrepid.animationexercise.base.BasePresenter;
import io.intrepid.animationexercise.base.PresenterConfiguration;


class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.Presenter {

    DetailPresenter(@NonNull DetailContract.View view, @NonNull PresenterConfiguration configuration) {
        super(view, configuration);
    }

    @Override
    public void onBackPressed() {
        view.animateImage();
    }

    @Override
    public void onViewCatClicked() {
        view.showCat();
        view.displayInstructions();
    }

    @Override
    public void onCatImageClicked() {
        view.animatePowerUp();
    }
}
