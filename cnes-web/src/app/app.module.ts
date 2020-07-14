import { ListaCnesService } from './services/lista-cnes.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadFileComponent } from './componentes/upload-file/upload-file.component';
import { ListaCNESComponent } from './componentes/lista-cnes/lista-cnes.component';
import { UploadFileService } from './services/upload-file.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AppComponent,
    UploadFileComponent,
    ListaCNESComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [
    UploadFileService,
    ListaCnesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
