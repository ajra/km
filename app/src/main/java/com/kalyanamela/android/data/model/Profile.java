package com.kalyanamela.android.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable {

    @SerializedName("Id")
    private String id;
    @SerializedName("profileno")
    private String profileNo;
    private String name;
    private String gender;
    private String dob;
    private String age;
    @SerializedName("birth_place")
    private String birthPlace;
    @SerializedName("mother_tongue")
    private String motherTongue;
    @SerializedName("birth_time")
    private String birthTime;
    private String irupu;
    @SerializedName("About_Me")
    private String aboutMe;
    private String thisai;
    private String religion;
    private String caste;
    private String subcaste;
    private String gotharam;
    private String rasi;
    private String starsign;
    private String lagnam;
    private String dosam;
    private double latitude;
    private double longitude;
    @SerializedName("dosamDetail")
    private String dosamdetail;
    private String martinativestaus;
    @SerializedName("noofchild")
    private String noOfChild;
    private String house;
    @SerializedName("residency_city")
    private String residencyCity;
    @SerializedName("mobile_no")
    private String mobileNo;
    @SerializedName("complexion_address")
    private String complexionAddress;
    private String height;
    private String weight;
    @SerializedName("eating_habit")
    private String eatingHabit;
    @SerializedName("Education")
    private String education;
    @SerializedName("Mothly_Income")
    private String monthlyIncome;
    @SerializedName("profile_image")
    private String profileImage;
    @SerializedName("profile_thump")
    private String profileThump;
    @SerializedName("Phy_Status")
    private String physicalStatus;
    @SerializedName("Occupation")
    private String Occupation;
    @SerializedName("PPAge_From")
    private String ppAgeFrom;
    @SerializedName("PPAge_To")
    private String ppAgeTo;
    @SerializedName("PPMonthly_Income")
    private String ppMonthlyIncome;
    @SerializedName("PPReligion")
    private String ppReligion;
    @SerializedName("PPCaste")
    private String ppCaste;
    @SerializedName("PPRassi")
    private String ppRassi;
    @SerializedName("PPStar_Sign")
    private String ppStarSign;
    @SerializedName("PPGothram")
    private String ppGothram;
    @SerializedName("PPmartial_Status")
    private String ppMartialStatus;
    @SerializedName("PPEducation")
    private String ppEducation;
    @SerializedName("PPSubCaste")
    private String ppSubCaste;
    @SerializedName("PPComplexion")
    private String ppComplexion;
    @SerializedName("PPEating_Habit")
    private String ppEatingHabit;
    @SerializedName("PPPhy_Status")
    private String ppPhyStatus;
    @SerializedName("Father_Name_en")
    private String fatherNameEn;
    @SerializedName("Mother_Name_en")
    private String motherNameEn;
    @SerializedName("No_of_Brother")
    private String noOfBrother;
    @SerializedName("No_of_Sister")
    private String noOfSister;
    @SerializedName("Married_Bro")
    private String marriedBro;
    @SerializedName("Married_Sis")
    private String marriedSister;
    @SerializedName("father_occupation")
    private String fatherOccupation;
    @SerializedName("mother_occupation")
    private String motherOccupation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileNo() {
        return profileNo;
    }

    public void setProfileNo(String profileNo) {
        this.profileNo = profileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getIrupu() {
        return irupu;
    }

    public void setIrupu(String irupu) {
        this.irupu = irupu;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getThisai() {
        return thisai;
    }

    public void setThisai(String thisai) {
        this.thisai = thisai;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getSubcaste() {
        return subcaste;
    }

    public void setSubcaste(String subcaste) {
        this.subcaste = subcaste;
    }

    public String getGotharam() {
        return gotharam;
    }

    public void setGotharam(String gotharam) {
        this.gotharam = gotharam;
    }

    public String getRasi() {
        return rasi;
    }

    public void setRasi(String rasi) {
        this.rasi = rasi;
    }

    public String getStarsign() {
        return starsign;
    }

    public void setStarsign(String starsign) {
        this.starsign = starsign;
    }

    public String getLagnam() {
        return lagnam;
    }

    public void setLagnam(String lagnam) {
        this.lagnam = lagnam;
    }

    public String getDosam() {
        return dosam;
    }

    public void setDosam(String dosam) {
        this.dosam = dosam;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDosamdetail() {
        return dosamdetail;
    }

    public void setDosamdetail(String dosamdetail) {
        this.dosamdetail = dosamdetail;
    }

    public String getMartinativestaus() {
        return martinativestaus;
    }

    public void setMartinativestaus(String martinativestaus) {
        this.martinativestaus = martinativestaus;
    }

    public String getNoOfChild() {
        return noOfChild;
    }

    public void setNoOfChild(String noOfChild) {
        this.noOfChild = noOfChild;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getResidencyCity() {
        return residencyCity;
    }

    public void setResidencyCity(String residencyCity) {
        this.residencyCity = residencyCity;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getComplexionAddress() {
        return complexionAddress;
    }

    public void setComplexionAddress(String complexionAddress) {
        this.complexionAddress = complexionAddress;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getEatingHabit() {
        return eatingHabit;
    }

    public void setEatingHabit(String eatingHabit) {
        this.eatingHabit = eatingHabit;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileThump() {
        return profileThump;
    }

    public void setProfileThump(String profileThump) {
        this.profileThump = profileThump;
    }

    public String getPhysicalStatus() {
        return physicalStatus;
    }

    public void setPhysicalStatus(String physicalStatus) {
        this.physicalStatus = physicalStatus;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getPpAgeFrom() {
        return ppAgeFrom;
    }

    public void setPpAgeFrom(String ppAgeFrom) {
        this.ppAgeFrom = ppAgeFrom;
    }

    public String getPpAgeTo() {
        return ppAgeTo;
    }

    public void setPpAgeTo(String ppAgeTo) {
        this.ppAgeTo = ppAgeTo;
    }

    public String getPpMonthlyIncome() {
        return ppMonthlyIncome;
    }

    public void setPpMonthlyIncome(String ppMonthlyIncome) {
        this.ppMonthlyIncome = ppMonthlyIncome;
    }

    public String getPpReligion() {
        return ppReligion;
    }

    public void setPpReligion(String ppReligion) {
        this.ppReligion = ppReligion;
    }

    public String getPpCaste() {
        return ppCaste;
    }

    public void setPpCaste(String ppCaste) {
        this.ppCaste = ppCaste;
    }

    public String getPpRassi() {
        return ppRassi;
    }

    public void setPpRassi(String ppRassi) {
        this.ppRassi = ppRassi;
    }

    public String getPpStarSign() {
        return ppStarSign;
    }

    public void setPpStarSign(String ppStarSign) {
        this.ppStarSign = ppStarSign;
    }

    public String getPpGothram() {
        return ppGothram;
    }

    public void setPpGothram(String ppGothram) {
        this.ppGothram = ppGothram;
    }

    public String getPpMartialStatus() {
        return ppMartialStatus;
    }

    public void setPpMartialStatus(String ppMartialStatus) {
        this.ppMartialStatus = ppMartialStatus;
    }

    public String getPpEducation() {
        return ppEducation;
    }

    public void setPpEducation(String ppEducation) {
        this.ppEducation = ppEducation;
    }

    public String getPpSubCaste() {
        return ppSubCaste;
    }

    public void setPpSubCaste(String ppSubCaste) {
        this.ppSubCaste = ppSubCaste;
    }

    public String getPpComplexion() {
        return ppComplexion;
    }

    public void setPpComplexion(String ppComplexion) {
        this.ppComplexion = ppComplexion;
    }

    public String getPpEatingHabit() {
        return ppEatingHabit;
    }

    public void setPpEatingHabit(String ppEatingHabit) {
        this.ppEatingHabit = ppEatingHabit;
    }

    public String getPpPhyStatus() {
        return ppPhyStatus;
    }

    public void setPpPhyStatus(String ppPhyStatus) {
        this.ppPhyStatus = ppPhyStatus;
    }

    public String getFatherNameEn() {
        return fatherNameEn;
    }

    public void setFatherNameEn(String fatherNameEn) {
        this.fatherNameEn = fatherNameEn;
    }

    public String getMotherNameEn() {
        return motherNameEn;
    }

    public void setMotherNameEn(String motherNameEn) {
        this.motherNameEn = motherNameEn;
    }

    public String getNoOfBrother() {
        return noOfBrother;
    }

    public void setNoOfBrother(String noOfBrother) {
        this.noOfBrother = noOfBrother;
    }

    public String getNoOfSister() {
        return noOfSister;
    }

    public void setNoOfSister(String noOfSister) {
        this.noOfSister = noOfSister;
    }

    public String getMarriedBro() {
        return marriedBro;
    }

    public void setMarriedBro(String marriedBro) {
        this.marriedBro = marriedBro;
    }

    public String getMarriedSister() {
        return marriedSister;
    }

    public void setMarriedSister(String marriedSister) {
        this.marriedSister = marriedSister;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.profileNo);
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeString(this.dob);
        dest.writeString(this.age);
        dest.writeString(this.birthPlace);
        dest.writeString(this.motherTongue);
        dest.writeString(this.birthTime);
        dest.writeString(this.irupu);
        dest.writeString(this.aboutMe);
        dest.writeString(this.thisai);
        dest.writeString(this.religion);
        dest.writeString(this.caste);
        dest.writeString(this.subcaste);
        dest.writeString(this.gotharam);
        dest.writeString(this.rasi);
        dest.writeString(this.starsign);
        dest.writeString(this.lagnam);
        dest.writeString(this.dosam);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.dosamdetail);
        dest.writeString(this.martinativestaus);
        dest.writeString(this.noOfChild);
        dest.writeString(this.house);
        dest.writeString(this.residencyCity);
        dest.writeString(this.mobileNo);
        dest.writeString(this.complexionAddress);
        dest.writeString(this.height);
        dest.writeString(this.weight);
        dest.writeString(this.eatingHabit);
        dest.writeString(this.education);
        dest.writeString(this.monthlyIncome);
        dest.writeString(this.profileImage);
        dest.writeString(this.profileThump);
        dest.writeString(this.physicalStatus);
        dest.writeString(this.Occupation);
        dest.writeString(this.ppAgeFrom);
        dest.writeString(this.ppAgeTo);
        dest.writeString(this.ppMonthlyIncome);
        dest.writeString(this.ppReligion);
        dest.writeString(this.ppCaste);
        dest.writeString(this.ppRassi);
        dest.writeString(this.ppStarSign);
        dest.writeString(this.ppGothram);
        dest.writeString(this.ppMartialStatus);
        dest.writeString(this.ppEducation);
        dest.writeString(this.ppSubCaste);
        dest.writeString(this.ppComplexion);
        dest.writeString(this.ppEatingHabit);
        dest.writeString(this.ppPhyStatus);
        dest.writeString(this.fatherNameEn);
        dest.writeString(this.motherNameEn);
        dest.writeString(this.noOfBrother);
        dest.writeString(this.noOfSister);
        dest.writeString(this.marriedBro);
        dest.writeString(this.marriedSister);
        dest.writeString(this.fatherOccupation);
        dest.writeString(this.motherOccupation);
    }

    public Profile() {
    }

    protected Profile(Parcel in) {
        this.id = in.readString();
        this.profileNo = in.readString();
        this.name = in.readString();
        this.gender = in.readString();
        this.dob = in.readString();
        this.age = in.readString();
        this.birthPlace = in.readString();
        this.motherTongue = in.readString();
        this.birthTime = in.readString();
        this.irupu = in.readString();
        this.aboutMe = in.readString();
        this.thisai = in.readString();
        this.religion = in.readString();
        this.caste = in.readString();
        this.subcaste = in.readString();
        this.gotharam = in.readString();
        this.rasi = in.readString();
        this.starsign = in.readString();
        this.lagnam = in.readString();
        this.dosam = in.readString();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.dosamdetail = in.readString();
        this.martinativestaus = in.readString();
        this.noOfChild = in.readString();
        this.house = in.readString();
        this.residencyCity = in.readString();
        this.mobileNo = in.readString();
        this.complexionAddress = in.readString();
        this.height = in.readString();
        this.weight = in.readString();
        this.eatingHabit = in.readString();
        this.education = in.readString();
        this.monthlyIncome = in.readString();
        this.profileImage = in.readString();
        this.profileThump = in.readString();
        this.physicalStatus = in.readString();
        this.Occupation = in.readString();
        this.ppAgeFrom = in.readString();
        this.ppAgeTo = in.readString();
        this.ppMonthlyIncome = in.readString();
        this.ppReligion = in.readString();
        this.ppCaste = in.readString();
        this.ppRassi = in.readString();
        this.ppStarSign = in.readString();
        this.ppGothram = in.readString();
        this.ppMartialStatus = in.readString();
        this.ppEducation = in.readString();
        this.ppSubCaste = in.readString();
        this.ppComplexion = in.readString();
        this.ppEatingHabit = in.readString();
        this.ppPhyStatus = in.readString();
        this.fatherNameEn = in.readString();
        this.motherNameEn = in.readString();
        this.noOfBrother = in.readString();
        this.noOfSister = in.readString();
        this.marriedBro = in.readString();
        this.marriedSister = in.readString();
        this.fatherOccupation = in.readString();
        this.motherOccupation = in.readString();
    }

    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}
