package com.abdulrehman1793;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(PowerMockRunner.class)
public class MainTest {
    @Test
    @PrepareForTest({Main.class})
    public void shouldFilterGetFirstNullThan() throws Exception {
        Main main = PowerMockito.spy(new Main());

        MultiValueMap<String, String> filters = PowerMockito.mock(LinkedMultiValueMap.class);
        PowerMockito.when(filters.getFirst("keyword")).thenReturn(null);

        ControlHelper controlHelper = PowerMockito.mock(ControlHelper.class);
        PowerMockito.whenNew(ControlHelper.class).withNoArguments().thenReturn(controlHelper);

        PowerMockito.when(controlHelper.hasData(filters)).thenReturn(true);

        main.filter(filters);

        Mockito.verify(controlHelper).hasData(ArgumentMatchers.any());
    }


    @Test
    @PrepareForTest({Main.class})
    public void shouldFilterGetFirstValue2Than() throws Exception {
        Main main = PowerMockito.spy(new Main());

        MultiValueMap<String, String> filters = PowerMockito.mock(LinkedMultiValueMap.class);
        PowerMockito.when(filters.getFirst("keyword")).thenReturn(AppConstant.Value2);

        PowerMockito.doNothing()
                .when(main, "voidHelperFunction1", filters);

        main.filter(filters);

        PowerMockito.verifyPrivate(main)
                .invoke("voidHelperFunction1", filters);
    }

    @Test
    @PrepareForTest({Main.class, Utility.class})
    public void shouldFilterGetFirstValue3Than() throws Exception {
        Main main = PowerMockito.spy(new Main());

        MultiValueMap<String, String> filters = PowerMockito.mock(LinkedMultiValueMap.class);
        PowerMockito.when(filters.getFirst("keyword")).thenReturn(AppConstant.Value3);

        String data = "some data";
        PowerMockito.doReturn(data)
                .when(main, "returnableHelperFunction2");

        PowerMockito.mockStatic(Utility.class);
        PowerMockito.doNothing().when(Utility.class, "doSomething", data);

        main.filter(filters);

        PowerMockito.verifyPrivate(main)
                .invoke("returnableHelperFunction2");

        PowerMockito.verifyStatic(Utility.class);
        Utility.doSomething(data);
    }
}