package api.megoru.ru.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participants {

    @JsonProperty("idUserWhoCreateGiveaway")
    public String idUserWhoCreateGiveaway;

    @JsonProperty("giveawayIdLong")
    public String giveawayIdLong;

    @JsonProperty("guildIdLong")
    public Long guildIdLong;

    @JsonProperty("userIdLong")
    public Long userIdLong;

    @JsonProperty("nickName")
    public String nickName;

    @JsonProperty("nickNameTag")
    public String nickNameTag;

    public Participants(String idUserWhoCreateGiveaway, String giveawayIdLong, Long guildIdLong, Long userIdLong, String nickName, String nickNameTag) {
        this.idUserWhoCreateGiveaway = idUserWhoCreateGiveaway;
        this.giveawayIdLong = giveawayIdLong;
        this.guildIdLong = guildIdLong;
        this.userIdLong = userIdLong;
        this.nickName = nickName;
        this.nickNameTag = nickNameTag;
    }

    public Participants() {
    }

    public String getIdUserWhoCreateGiveaway() {
        return idUserWhoCreateGiveaway;
    }

    public String getGiveawayIdLong() {
        return giveawayIdLong;
    }

    public Long getGuildIdLong() {
        return guildIdLong;
    }

    public Long getUserIdLong() {
        return userIdLong;
    }

    public String getNickName() {
        return nickName;
    }

    public String getNickNameTag() {
        return nickNameTag;
    }

    public void setIdUserWhoCreateGiveaway(String idUserWhoCreateGiveaway) {
        this.idUserWhoCreateGiveaway = idUserWhoCreateGiveaway;
    }

    public void setGiveawayIdLong(String giveawayIdLong) {
        this.giveawayIdLong = giveawayIdLong;
    }

    public void setGuildIdLong(Long guildIdLong) {
        this.guildIdLong = guildIdLong;
    }

    public void setUserIdLong(Long userIdLong) {
        this.userIdLong = userIdLong;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setNickNameTag(String nickNameTag) {
        this.nickNameTag = nickNameTag;
    }
}