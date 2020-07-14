import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TitleCasePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  /**
   * Construtor do Serviço para realizar upload
   * @param https 
   */
  constructor(private https: HttpClient) { }

  /*
   * Headers
   */
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  /**
   * Realizar upload do arquivo
   * @param arquivo 
   */
  realizarUpload(arquivo: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData();

    data.append('file', arquivo);

    const newRequest = new HttpRequest('POST', 'http://localhost:8080/api/arquivos/', data, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.https.request(newRequest);
  }
}