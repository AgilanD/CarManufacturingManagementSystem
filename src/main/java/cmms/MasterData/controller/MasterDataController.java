package cmms.MasterData.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MasterData")
public class MasterDataController {


    @GetMapping("/Checking")
    public String Checkings(){

        return "Checking From the MasterData";

    }

}
