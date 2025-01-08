import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { provideHttpClient, withFetch } from '@angular/common/http';

providers: [provideHttpClient(withFetch())]

platformBrowserDynamic().bootstrapModule(AppModule, {
  
  ngZoneEventCoalescing: true,

})
  .catch(err => console.error(err));
