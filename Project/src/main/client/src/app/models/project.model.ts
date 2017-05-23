import { Goal } from './goal.model'

export interface Project {
  projectID: string;
  name: string;
  creationDate: string;
  description: string;
  version: string;
  goalRef: Goal[];
}
