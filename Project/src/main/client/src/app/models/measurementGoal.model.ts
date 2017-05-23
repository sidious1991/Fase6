import { Question } from './question.model';
import { Metric } from './metric.model';

export interface MeasurementGoal {
  	measurementGoalId: string;
    object: string;
    purpose: string;
    qualityFocus: string;
    viewpoint: string;
    context: string;
    creationDate: string;
    lastModified: string;
    interpretationModel: string; 
    version: number;
    questionsRef: Question[];
    metricsRef: Metric[];
}
