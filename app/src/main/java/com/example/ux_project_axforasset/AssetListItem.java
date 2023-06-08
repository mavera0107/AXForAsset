package com.example.ux_project_axforasset;

public class AssetListItem {

    private String assetName; // ya nama asset.
    private String assetShortDesc; // ini yang bakal muncul di assetlist di itemPagenya

    private String assetLongDesc; // (kemungkinan ini yang bakal muncul di asset view pagenya (halaman game views)

    private String assetPrice; // harga asset disimpan dalam string atau mungkin gausa

    private int assetImage;

    // konstrutkor
    public AssetListItem(String assetname, String shortdesc, String assetprice, int assetImage, String longdesc){
        this.assetName = assetname;
        this.assetShortDesc = shortdesc;
        this.assetPrice = assetprice;
        this.assetImage = assetImage;
        this.assetLongDesc = longdesc;
    }

    public int getAssetImage() {
        return assetImage;
    }

    public String getAssetPrice() {
        return assetPrice;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetShortDesc() {
        return assetShortDesc;
    }

    public String getAssetLongDesc() {
        return assetLongDesc;
    }
}
