![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
## Pro.Engineer.Java.CalculationWelds.IBeam
<a name="readme-top"></a>
### Настольное приложение для проверки сварных швов приварки двутавра.

#### Цель разработки: проверка сварного соединения на соответствие п. 14.1.16, 14.1.17, 14.1.18 СП 16.13330.2017.

<p align="center">
<img src="images/base.png" alt="drawing" width="650"/>
</p>

#### В приложении использована архитектура с разделенной моделью (separable model architecture)
#### или отношение модель-представитель (model-delegate).

* В приложении предусмотрены следующие расположения ребер:

<p align="center">
<img src="images/1_4.png" alt="drawing" width="650"/>
<img src="images/5_8.png" alt="drawing" width="650"/>
</p>

* Предусмотрена возможность задания разных катетов сварных швов приварки стенки и полки двутавра. 

<p align="center">
<img src="images/beam.png" alt="drawing" width="130"/>
</p>

* При расчете характеристик сварных швов учитываются геометрические размеры каждого ребра.

<p align="center">
<img src="images/ribs123.png" alt="drawing" width="650"/>
</p>

* Предусмотрен выбор расчетного сопротивления Rwf угловых швов срезу (условному) по металлу шва из таблицы:

<p align="center">
<img src="images/rwf.png" alt="drawing" width="520"/>
</p>

* Предусмотрен выбор расчетного сопротивления Rwz угловых швов срезу (условному) по металлу границы сплавления из таблицы:

<p align="center">
<img src="images/rwz.png" alt="drawing" width="650"/>
</p>

* Согласно п. 14.1.16 СП 16.13330.2017, из длины каждого непрерывного участка сварного шва вычитается 1 см.

* Приложение позволяет произвести расчет сварных швов на действие N, Qx, Qy, Mx, My

<p align="center">
<img src="images/forces.png" alt="drawing" width="300"/>
</p>

* Реализована проверка применяемых сварочных материалов на условия п. 14.1.8 СП 16.13330.2017.

* Предусмотрена возможность создания txt файла с результатами расчета.

#### N.B. Приложение в стадии разработки. Планируются изменения.

<p align="right">(<a href="#readme-top">back to top</a>)</p>