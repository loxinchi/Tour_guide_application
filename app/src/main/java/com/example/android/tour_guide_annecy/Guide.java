package com.example.android.tour_guide_annecy;


/**
 * {@link Guide} represents the guide information that introduced in this tour guide app.
 * It contains resource IDs for the Name, Region, Image, Phone number, Address, Website.
 */
public class Guide {

    /** String resource ID for Name */
    private int mNameId;

    /** String resource ID for Region */
    private int mRegionId;

    /** Audio resource ID for the Image */
    private int mImageResourceId;

    /** String resource ID for Phone number */
    private int mPhoneNumberId;

    /** String resource ID for Address */
    private int mAddressId;

    /** Audio resource ID for the Website */
    private int mWebURLId;

    /**
     * Create a new Word object.
     *
     * @param nameId is the string resource Id for the name of this store
     * @param regionId is the string resource Id for the region of this store
     * @param imageResourceId is the resource ID for the image file associated with this store
//     * @param phoneNumberId is the string resource ID for phone number of this store
//     * @param addressId is the string resource Id for the address of this store
//     * @param webURLId is the resource ID for the web url of this store
     */
    public Guide(int nameId, int regionId, int imageResourceId) {
        mNameId = nameId;
        mRegionId = regionId;
        mImageResourceId = imageResourceId;
//        mPhoneNumberId = phoneNumberId;
//        mAddressId = addressId;
//        mWebURLId = webURLId;
    }

    /**
     * Create a new Word object.
     *
     * @param nameId is the string resource Id for the name of this store
     * @param regionId is the string resource Id for the region of this store
     * @param imageResourceId is the resource ID for the image file associated with this store
     * @param phoneNumberId is the string resource ID for phone number of this store
     * @param addressId is the string resource Id for the address of this store
     * @param webURLId is the resource ID for the web url of this store
     */
    public Guide(int nameId, int regionId, int imageResourceId, int phoneNumberId, int addressId, int webURLId) {
        mNameId = nameId;
        mRegionId = regionId;
        mImageResourceId = imageResourceId;
        mPhoneNumberId = phoneNumberId;
        mAddressId = addressId;
        mWebURLId = webURLId;
    }

    /**
     * Get the string resource ID for for the name of the store.
     */
    public int getNameIdnameId() {
        return mNameId;
    }

    /**
     * Get the string resource ID for the region of the store.
     */
    public int getRegionId() {
        return mRegionId;
    }

    /**
     * Get the string resource ID for the image file associated.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the string resource ID for the phone number of the store.
     */
    public int getPhoneNumberId() {
        return mPhoneNumberId;
    }

    /**
     * Get the string resource ID for the address of the store.
     */
    public int getAddressId() {
        return mAddressId;
    }

    /**
     * Get the string resource ID for the website url of the store.
     */
    public int getWebURLId() {
        return mWebURLId;
    }
}
