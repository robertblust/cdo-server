package ch.flatland.cdo.util

import org.eclipse.xtend.lib.annotations.Data

@Data class MessageResponse {
	OkStatus status = new OkStatus
	Object data
}
