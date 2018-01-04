package io.intrepid.animationexercise.screens.overview;

import android.support.annotation.NonNull;

import io.intrepid.animationexercise.base.BasePresenter;
import io.intrepid.animationexercise.base.PresenterConfiguration;
import io.intrepid.animationexercise.models.Cat;
import io.intrepid.animationexercise.utils.DataUtils;


class OverviewPresenter extends BasePresenter<OverviewContract.View> implements OverviewContract.Presenter {

    OverviewPresenter(@NonNull OverviewContract.View view, @NonNull PresenterConfiguration configuration) {
        super(view, configuration);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        loadCats(true);
    }

    @Override
    public void loadCats(boolean loadLocal) {
        view.toggleLoadingSpinner(true);
        if (loadLocal) {
            view.onCatsLoaded(DataUtils.getData());
            view.toggleLoadingSpinner(false);
        } else {
            throw new UnsupportedOperationException("Only dummy data allowed for this exercise");
        }
    }

    @Override
    public void onCatClicked(Cat cat) {
        view.goToCatDetail(cat);
    }
}
