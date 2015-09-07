package com.drfits.transfer;

/**
 * Created by Evgeniy Fitsner <drfits@drfits.com> on 8/30/15.
 */
public class TransferImpl implements Transfer {

    private String data;

    public TransferImpl(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
