package com.abdulrehman1793;

import org.springframework.util.MultiValueMap;

public class Main extends GenericBase<MultiValueMap<String, String>> {

    private final Facade1 facade1 = new Facade1();

    Long startTime;

    @Override
    ControlHelper filter(MultiValueMap<String, String> filters) {

        startTime = SystemUtil.getLocalTime();

        String mapKey = filters.getFirst("keyword");

        ControlHelper controlHelper = null;

        if (mapKey == null) {
            controlHelper = new ControlHelper();
        } else if (mapKey.equals(AppConstant.Value2)) {
            voidHelperFunction1(filters);
        } else if (mapKey.equals(AppConstant.Value3)) {
            String data = returnableHelperFunction2();
            Utility.doSomething(data);
        }

        if (controlHelper != null && controlHelper.hasData(filters)) {
            System.out.println("working as expected");
        }

        return controlHelper;
    }

    private void voidHelperFunction1(MultiValueMap<String, String> filters) {
        // some logic
        filters.entrySet().forEach(stringListEntry -> System.out.println(stringListEntry.toString()));
        facade1.method1();
    }

    private String returnableHelperFunction2() {

        return "returnable helper function";
    }

    @Override
    void update() {

    }

    @Override
    void delete() {

    }
}
