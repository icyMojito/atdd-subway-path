package wooteco.subway.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import wooteco.subway.admin.dto.ExceptionResponse;
import wooteco.subway.admin.exceptions.DuplicatedStationsException;
import wooteco.subway.admin.exceptions.NotExistStationException;
import wooteco.subway.admin.exceptions.UnconnectedStationsException;

@ControllerAdvice
public class ExceptionAdvice {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotExistStationException.class)
	public ExceptionResponse notExistStation(NotExistStationException e) {
		return new ExceptionResponse("NOT_EXIST_STATION", e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicatedStationsException.class)
	public ExceptionResponse duplicatedStation(DuplicatedStationsException e) {
		return new ExceptionResponse("DUPLICATED_STATION", e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnconnectedStationsException.class)
	public ExceptionResponse unconnectedStation(UnconnectedStationsException e) {
		return new ExceptionResponse("UNCONNECTED_STATIONS", e.getMessage());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ExceptionResponse otherExceptions(Exception e) {
		return new ExceptionResponse("SERVER_ERROR", "시스템 에러입니다!");
	}
}
