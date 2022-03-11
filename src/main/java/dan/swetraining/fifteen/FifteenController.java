package dan.swetraining.fifteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FifteenController {

	Fifteen f = new Fifteen();

	public FifteenController() {
		f.setupBoard();
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@PostMapping("/")
	public FifteenResponseDto getBoard(@RequestBody FifteenRequestDto req){
		
		String result = f.tryMove(Integer.valueOf(req.move));
		
		FifteenResponseDto response = new FifteenResponseDto();
		response.msg = result;
		response.board = f.toArray();
		return response;
	}
}
