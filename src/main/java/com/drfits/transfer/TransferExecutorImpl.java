package com.drfits.transfer;

import com.drfits.annotation.RunMethod;

/**
 * Class contains methods for execute {@link Transfer} objects
 */
public class TransferExecutorImpl implements TransferExecutor {

    @RunMethod
    public Void execute(Transfer transfer) {
        String msg;
        if (transfer != null) {
            msg = "Execute data: " + transfer.getData();
        } else {
            msg = "transfer object is null";
        }
        System.out.println(msg);
        return null;
    }
}
