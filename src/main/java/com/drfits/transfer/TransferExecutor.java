package com.drfits.transfer;

/**
 * Created by Evgeniy Fitsner <drfits@drfits.com> on 8/30/15.
 */
public interface TransferExecutor {
    /**
     * Execute specified interface
     *
     * @param transfer
     */
    Void execute(Transfer transfer);
}
