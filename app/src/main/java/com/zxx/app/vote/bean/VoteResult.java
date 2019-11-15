package com.zxx.app.vote.bean;

import java.util.List;

/**
 * Created by yfy1 on 2017/3/25.
 */

public class VoteResult {
    private List<VoteInfor> Votedetail;

    public List<VoteInfor> getVotedetail() {
        return Votedetail;
    }

    public void setVotedetail(List<VoteInfor> votedetail) {
        Votedetail = votedetail;
    }
}
