package project.skat.kodetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class KodetestController {

    @GetMapping("/api/convert/{number}")
    @ResponseBody
    public String convertToStringLiteral(@PathVariable String number) {
        return NumberToStringLiteral.convert(Double.parseDouble(number));
    }

}

