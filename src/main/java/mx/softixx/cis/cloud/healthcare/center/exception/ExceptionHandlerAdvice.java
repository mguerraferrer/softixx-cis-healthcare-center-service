package mx.softixx.cis.cloud.healthcare.center.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import mx.softixx.cis.common.healthcare.center.exception.PrivatePracticeAlreadyExistsException;
import mx.softixx.cis.common.healthcare.center.exception.PrivatePracticeHashException;
import mx.softixx.cis.common.healthcare.center.exception.PrivatePracticeNotFoundException;
import mx.softixx.cis.common.validation.util.ProblemDetailUtils;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(PrivatePracticeNotFoundException.class)
	public ProblemDetail handlerPrivatePracticeNotFoundException(PrivatePracticeNotFoundException e) {
		return ProblemDetailUtils.notFound(e.getMessage());
	}

	@ExceptionHandler(PrivatePracticeAlreadyExistsException.class)
	public ProblemDetail handlerPrivatePracticeAlreadyExistsException(PrivatePracticeAlreadyExistsException e) {
		return ProblemDetailUtils.preconditionFailed(e.getMessage());
	}

	@ExceptionHandler(PrivatePracticeHashException.class)
	public ProblemDetail handlerPrivatePracticeHashException(PrivatePracticeHashException e) {
		return ProblemDetailUtils.preconditionFailed(e.getMessage());
	}

}