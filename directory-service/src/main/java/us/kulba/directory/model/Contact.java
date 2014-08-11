package us.kulba.directory.model;

import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.bson.types.ObjectId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO for holding Contact info in the Directory.
 *
 */
@Document(collection = "contacts")
public class Contact {

    @Id
    protected final String id;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private String nickname;
    private Date dateEntered;
    private Date dateUpdated;
//    private List<Address> addressList = new ArrayList<Address>();
//    private List<Phone> phoneList = new ArrayList<Phone>();
//    private List<String> groupList = new ArrayList<String>();

    public Contact() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));
        this.setDateEntered(calendar.getTime());
        this.id = new ObjectId().toString();
    }

    public String getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public Date getDateEntered() {
        return dateEntered;
    }

    private void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

//    public List<Phone> getPhoneList() { return phoneList; }

//    public void setPhoneList(List<Phone> phoneList) { this.phoneList = phoneList; }

//    public void addPhone(Phone phone) { this.phoneList.add(phone); }

//    public List<Address> getAddressList() { return addressList; }

//    public void setAddressList(List<Address> addressList) { this.addressList = addressList; }

//    public void addAddress(Address address) {
//        this.addressList.add(address);
//    }

//    public List<String> getGroupList() { return groupList; }

//    public void setGroupList(List<String> groupList) {this.groupList = groupList;}

//    public void addGroup(String group) { this.getGroupList().add(group); }

    @JsonIgnore
    public String getFullName() {
        String fullName[] = {firstName, lastName};
        return StringUtils.join(fullName, " ");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}
