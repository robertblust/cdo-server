package ch.flatland.cdo.util

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString
class CommitMessage {
	String timestamp
	String service
	long newObjects
	long changedObjects
	long deletedObjects
}