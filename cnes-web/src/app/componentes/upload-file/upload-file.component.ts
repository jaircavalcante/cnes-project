import { UploadFileService } from './../../services/upload-file.service';
import { Component } from '@angular/core';
import { HttpEventType, HttpEvent } from '@angular/common/http';


@Component({
  selector: 'app-upload-file',
  templateUrl: './upload-file.component.html',
  styleUrls: ['./upload-file.component.css']
})
export class UploadFileComponent {

  nomeArquivo : string;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  selectedFile = null;
  progresso = false;

  constructor(private uploadService: UploadFileService){}


  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.nomeArquivo       = this.selectedFiles.item(0).name;
    this.progresso = true;
    this.uploadService.realizarUpload(this.currentFileUpload)
      .subscribe((event :  HttpEvent<Object>) =>  {
        console.log(event);
        if(event.type === HttpEventType.Response){
          if(event.status === 200){
            this.progresso = false;
            alert("Arquivo importado!");
          }
        }
        this.selectedFiles = undefined;
      });
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
}
