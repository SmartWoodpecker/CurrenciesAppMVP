package rudenko.andrey.currenciesapp.presentation.view;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rudenko.andrey on 26.05.2018.
 */

public interface DateListView {
    void createScrollListener();

    void addProposalsToList(ArrayList<Date> dates);

    void navigateToDateDetailsAtcivity(Date date);
}
