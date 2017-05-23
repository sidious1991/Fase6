import { Goal } from './goal.model';
import { Project } from './project.model';

export interface Status {
  statusId: string;
	status: string;
	creationDate: string;
	lastModified: string;
	goalRef: Goal;
	projectRef: Project;
}
