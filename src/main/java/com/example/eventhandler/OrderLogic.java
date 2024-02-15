////////////////////////////////////////////////////////////////////////////////////////\\
//                                                                                      \\
//          ONLINE PIZZA PROJECT STORE                                                  \\
//                                                                                      \\
//          CREATED BY: BARA AHMAD MOHAMMED                                             \\
//                                                                                      \\
//           SUBMITTED TO PROF. COLIN. P                                                \\
//                                                                                      \\
//             25TH DECEMBER, 2023                                                      \\
//////////////////////////////////////////////////////////////////////////////////////////

package com.example.eventhandler;

public class OrderLogic {

    private String orderText;

    public String getOrderText()
    {
        return orderText;
    }

    public void setOrderType(String text)
    {
        orderText += "\n" + text;
    }
}
