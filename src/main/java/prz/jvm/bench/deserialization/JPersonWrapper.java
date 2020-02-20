package prz.jvm.bench.deserialization;

import com.dslplatform.json.CompiledJson;

import java.util.List;

@CompiledJson
public class JPersonWrapper {
    private List<JPerson> persons;

    public List<JPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<JPerson> persons) {
        this.persons = persons;
    }

    @CompiledJson
    static class JPerson {
        private String _id;
        private int index;
        private String guid;
        private boolean isActive;
        private String balance;
        private String picture;
        private int age;
        private String eyeColor;
        private String name;
        private String gender;
        private String company;
        private String email;
        private String phone;
        private String address;
        private String about;
        private String registered;
        private double latitude;
        private double longitude;
        List<String> tags;
        List<JFriend> friends;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getGuid() {
            return guid;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
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

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public String getRegistered() {
            return registered;
        }

        public void setRegistered(String registered) {
            this.registered = registered;
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

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<JFriend> getFriends() {
            return friends;
        }

        public void setFriends(List<JFriend> friends) {
            this.friends = friends;
        }

        @CompiledJson
        static class JFriend {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
