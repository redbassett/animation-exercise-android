package io.intrepid.animationexercise.screens.overview;

import java.util.List;

import io.intrepid.animationexercise.base.BaseContract;
import io.intrepid.animationexercise.models.Cat;

class OverviewContract {
    public interface View extends BaseContract.View {
        void toggleLoadingSpinner(boolean visible);

        void goToCatDetail(Cat cat);

        void onCatsLoaded(List<Cat> cats);
    }

    public interface Presenter extends BaseContract.Presenter<View> {
        void loadCats(boolean loadLocal);

        void onCatClicked(Cat cat);
    }
}
