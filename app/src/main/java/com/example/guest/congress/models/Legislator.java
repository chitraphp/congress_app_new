package com.example.guest.congress.models;


/**
 * Created by Guest on 11/3/15.
 */
public class Legislator {

    private String mBioguideId, mFirstName, mLastName, mParty, mTitle, mEmail, mPhone, mOffice, mWebsite;

    public Legislator(String bioguideId, String firstName, String lastName, String party, String title, String email, String phone, String office, String website){
        mBioguideId = bioguideId;
        mFirstName = firstName;
        mLastName = lastName;
        mParty = party;
        mTitle = title;
        mEmail = email;
        mPhone = phone;
        mOffice = office;
        mWebsite = website;

    }

    public String getBioguideId() {
        return mBioguideId;
    }

    public void setBioguideId(String bioguideId) {
        mBioguideId = bioguideId;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getParty() {
        return mParty;
    }

    public void setParty(String party) {
        this.mParty = party;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getOffice() {
        return mOffice;
    }

    public void setOffice(String office) {
        mOffice = office;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }
}
