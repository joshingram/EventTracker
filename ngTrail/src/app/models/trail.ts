export class Trail {
id: number;
name: string;
length: number | undefined;
dateCompleted: string | null;
imageUrl: string | undefined;
entranceLatitude: number | undefined;
entranceLongitude: number | undefined;
highestElevation: number | undefined;
notes: string | undefined;

constructor(id: number = 0, name: string ='', length?: number, dateCompleted: string = '',
  imageUrl?: string, entranceLatitude?: number, entranceLongitude?: number,
  highestElevation?: number, notes?: string){
this.id = id;
this.name = name;
this.length = length;
this.dateCompleted = dateCompleted;
this.imageUrl = imageUrl;
this.entranceLatitude = entranceLatitude;
this.entranceLongitude = entranceLongitude;
this.highestElevation = highestElevation;
this.notes = notes;
  }
}
