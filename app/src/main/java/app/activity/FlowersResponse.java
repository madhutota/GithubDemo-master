package app.activity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by madhu on 23-Mar-18.
 */

public class FlowersResponse {
    @SerializedName("totalHits")
    private int totalHits;
    @SerializedName("hits")
    private List<FlowerModel> flowersList;

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public List<FlowerModel> getFlowersList() {
        return flowersList;
    }

    public void setFlowersList(List<FlowerModel> flowersList) {
        this.flowersList = flowersList;
    }
}
