package io.intrepid.animationexercise.screens.overview;

import android.support.annotation.NonNull;

import io.intrepid.animationexercise.base.BasePresenter;
import io.intrepid.animationexercise.base.PresenterConfiguration;
import io.intrepid.animationexercise.models.Cat;
import io.intrepid.animationexercise.utils.DataUtils;
import io.intrepid.animationexercise.utils.RxUtils;
import rx.Subscription;


class OverviewPresenter extends BasePresenter<OverviewContract.View> implements OverviewContract.Presenter {

    private static final int CAT_PAGE_SIZE = 20;

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
            Subscription loadCats = restApi.getCats(CAT_PAGE_SIZE, "xml", "jpg,png")
                    .compose(subscribeOnIoObserveOnUi())
                    .subscribe((catResponse) -> {
                        view.onCatsLoaded(catResponse.getCats());
                        view.toggleLoadingSpinner(false);
                    }, RxUtils.logError());
            subscriptions.add(loadCats);
        }
    }

    @Override
    public void onCatClicked(Cat cat) {
        view.goToCatDetail(cat);
    }
}
